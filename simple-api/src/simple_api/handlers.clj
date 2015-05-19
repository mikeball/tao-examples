(ns simple-api.handlers
  (:require [cheshire.core :refer [generate-string]]))


(defn json-msg [msg]
  (generate-string {:message msg}))


(defn hello [ctx]
  [200 {} (json-msg "hello from simple api")])


(defn not-found [ctx]
  [404 {} (json-msg "sorry, not found")])


(defn not-authorized [ctx]
  [403 {} (json-msg "sorry, not authorized")])


(defn server-error [ctx]
  [500 {} (json-msg "sorry, an error occured")])