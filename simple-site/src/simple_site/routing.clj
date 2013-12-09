(ns simple-site.routing
  (:require [taoclj.tao :refer [deftable]]
            [simple-site.handlers :as site]
            [simple-site.items.handlers :as items]))


(deftable routes
    :public
    ["/" {:get site/index}]
    ["/items" {:get items/index}]
    ["/items/:id" {:get items/detail}])