(ns simple-api.items.handlers)


(defn list [ctx]
  [200 {} "{\"items\":[{\"name\":\"item a\"},{\"name\":\"item b\"}]}"])