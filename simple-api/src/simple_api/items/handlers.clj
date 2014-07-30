(ns simple-api.items.handlers
  (:require [taoclj.pure :as pure]
            [cheshire.core :refer [generate-string]]
            [simple-api.items.repo :as repo]))


(defn list [_]
  [200 {} (generate-string (repo/get-list))])


(defn detail [ctx]
  (let [id   (pure/parse-int (-> ctx :params :id))
        item (repo/get-item id)]
    (if-not item
      [404 {:content-type "text/plain"} (str "sorry item not found")]
      [200 {} (generate-string item)])))




; (defh detail
;   {:id [:int :required "ID is required"]}
;   [ctx params]

;   (if (params :errors)
;     [400 {} (generate-string (params :errors))]
;     (let [item (repo/get-item (params :values :id))]
;       (if-not item
;         [404 {:content-type "text/plain"} (str "sorry item not found")]
;         [200 {} (generate-string item)]))))
