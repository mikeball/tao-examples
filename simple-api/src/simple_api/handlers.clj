(ns simple-api.handlers)


(defn hello [ctx]
  [200 {} "{\"message\":\"hello from simple api.\"}"])


(defn not-found [ctx]
  [404 {:content-type "text/plain"} "sorry, not found"])


(defn not-authorized [ctx]
  [403 {:content-type "text/plain"} "sorry, not authorized"])