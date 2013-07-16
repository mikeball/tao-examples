(ns simple-site.items.handlers
  (:require [taoclj.mustache :as tpl]))


(defn index [ctx]
  [200 {} (tpl/render :items.index {:message "Items are here..."})])
