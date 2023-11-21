(ns c2.main
  (:require [clojure.tools.logging :as log]
            [org.httpkit.server :as kit]
            [c2.handler :as api]))

(defn -main [& _args]
  (try
    (kit/run-server #'api/app {:port 8010})
    (catch Exception e
      (log/error "Exception during mounting resources! \n" e))))
