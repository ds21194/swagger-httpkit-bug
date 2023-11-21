(ns c2.schema
  (:require [compojure.api.sweet :refer [context GET resource defroutes routes]]
            [ring.util.http-response :refer [ok]]
            [schema.core :as s]))

(s/defschema Total
  {:total s/Int})

(s/defschema HelloWorld
  {:result s/Str})

(def routes*
  (routes
    (context "/" []
      (GET "/" []
        :summary "hello world"
        :return HelloWorld
        (ok {:result "hello world"})))

    (context "/schema" []
     :tags ["schema"]
     (GET "/plus" []
       :summary "plus with schema"
       :query-params [x :- s/Int, {y :- s/Int 0}]
       :return Total
       (ok {:total (+ x y)}))

     (context "/data-plus" []
       (resource
         {:post
          {:summary    "data-driven plus with schema"
           :parameters {:body-params {:x s/Int, :y s/Int}}
           :responses  {200 {:schema Total}}
           :handler    (fn [{{:keys [x y]} :body-params}]
                         (ok {:total (+ x y)}))}})))))