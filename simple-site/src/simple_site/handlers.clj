(ns simple-site.handlers
  (:require [taoclj.mustache :as tpl]))


(defn index [ctx]
  [200 {} (tpl/render :index {:message "why hello!"})])


(defn not-found [ctx]
  [404 {} (tpl/render :not-found {})])


(defn not-authorized [ctx]
  [403 {} "sorry, not authorized"])