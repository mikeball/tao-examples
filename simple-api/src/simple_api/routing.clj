(ns simple-api.routing
  (:require [taoclj.tao :refer [defroutes]]
            [simple-api.handlers :as api]))


(defroutes routes :public 
                  ["/" {:get api/hello}])