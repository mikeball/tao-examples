(ns simple-api.items.handlers
  (:require [taoclj.pure :as pure]
            [clojure.data.json :as json]
            [simple-api.items.repo :as repo]))


(defn list [_]
  [200 {} (json/write-str (repo/get-list))])


(defn detail [ctx]
  (let [id (pure/parse :int (-> ctx :params :id))
        item (repo/get-item id)]
    (if-not item
      [404 {} (str "sorry item not found")]
      [200 {} (json/write-str item)])))
