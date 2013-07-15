(ns simple-site.routing
  (:require [taoclj.tao :refer [defroutes]]
            [simple-site.handlers :as site]))


(defroutes routes :public 
                  ["/" {:get site/home-page}])