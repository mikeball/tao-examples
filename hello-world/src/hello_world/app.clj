(ns hello-world.app
  (:require [taoclj.tao.routing :refer [deftable fn-dispatch]]))


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
(deftable routes
    :public
    ["/" {:get home-page}])


;; fn-dispatch creates a ring function that takes a ring request,
;; matches it against the routing table, then invokes the appropiate handler
;; and returns a ring response.
(def dispatch
    (fn-dispatch {:routes routes ; [["/" {:get [home-page :public]}]]

                  ;; this parameter sets the default http content-type
                  ;; header which is used for all requests, unless over-ridden
                  ;; by in the response command map.
                  :content-type "text/plain;charset=utf-8"}))





