(ns simple-api.items.handlers
  (:require [taoclj.tao :refer [rsx->]]
            [taoclj.pure :refer [parse-int]]
            [cheshire.core :refer [generate-string]]
            [simple-api.items.repo :as repo]
            [simple-api.handlers :refer [not-found server-error]]))


(defn show-list [items ctx]
  (cond (false? items)  (server-error ctx)
        :else           [200 {} (generate-string items)]))

(defn get-list [ctx]
  (rsx-> (repo/get-items)
         (show-list ctx)))



(defn show-item [item ctx]
  (cond (nil? item)    (not-found ctx)
        (false? item)  (server-error ctx)
        :else          [200 {} (generate-string item)]))


; pipelined style handler
(defn detail [ctx]
  (rsx-> (parse-int (-> ctx :params :id))
         repo/lookup-item
         (show-item ctx)))



