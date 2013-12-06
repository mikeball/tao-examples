(ns hello-world.app
  (:require [taoclj.tao :refer [deftable gen-dispatch]]))

;; First we define a handler. In tao handlers are plain old functions
;; that take a single parameter and return a vector with 3 elements.
(defn home-page [_] [200 {} "hello tao!"])

;; The defroutes macro builds a routing table from a sequence 
;; of alternating keyword(s) and vector(s). The keywords are user roles
;;
;;    [path-pattern methods-map]
;;
;; Here we define a single route, marked as public that matches http requests
;; to the root path "/" and http method GET.
(deftable routes :public 
                 ["/" {:get home-page}])



(def dispatch

    ;; gen-dispatch creates a ring function that takes a ring request,
    ;; matches it against the routing table, then invokes the appropiate handler
    ;; and returns a ring response.
    (-> (gen-dispatch routes
                    
                    ;; this parameter sets the default http content-type
                    ;; header which is used for all requests, unless over-ridden
                    ;; by in the response command map.
                    "text/plain;charset=utf-8"
                    
                    ;; if no handler & method match is found in the routing table
                    ;; this not-found handler is invoked and it's result is returned.
                    ;; this function must return a vector with 3 elements in the format
                    ;; [int map body].
                    (fn [_] [404 {} "sorry, not found"])
                    
                    
                    ;; if a route match is found but the user has not been
                    ;; marked as being in any of the roles required to access
                    ;; the handler this function is invoked and the result is returned.
                    (fn [_] [403 {} "sorry, not authorized"]))))




  