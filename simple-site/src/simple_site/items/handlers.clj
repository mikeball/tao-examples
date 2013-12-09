(ns simple-site.items.handlers
  (:require [taoclj.pure :as pure]
            [simple-site.items.repo :as repo]
            [simple-site.handlers :refer [render]]))


(defn index [_]
  [200 {} (render :items.index
                  {:message "Here's a list of the current items"
                   :items (repo/get-list)})])


(defn detail [ctx]
  (let [id (pure/parse :int (-> ctx :params :id))
        item (repo/get-item id)]
    (if-not item
      [404 {} (str "sorry item not found")]
      [200 {} (render :items.detail item)])))
