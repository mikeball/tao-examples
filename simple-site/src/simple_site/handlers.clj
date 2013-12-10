(ns simple-site.handlers
  (:require [taoclj.mustache :refer [gen-renderer]]))


(def render (gen-renderer "ui" "tpl" false))


(defn index [ctx]
  [200 {} (render :index {:message "hello..."})])


(defn not-found [ctx]
  [404 {} (render :not-found {})])


(defn not-authorized [ctx]
  [403 {} "sorry, not authorized"])