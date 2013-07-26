(ns simple-api.handlers
  (:require [cheshire.core :refer [generate-string]]))


(defn hello [ctx]
  [200 {} (generate-string {:message "hello from simple api"})])


(defn not-found [ctx]
  [404 {:content-type "text/plain"} "sorry, not found"])


(defn not-authorized [ctx]
  [403 {:content-type "text/plain"} "sorry, not authorized"])