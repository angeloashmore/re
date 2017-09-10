(ns re.app
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [re.events]
            [re.subs]
            [re.routes :as routes]
            [re.views :as views]
            [re.config :as config]))

(defn dev-setup
  []
  (when config/dev?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root
  []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init
  []
  (routes/app-routes)
  ; (re-frame/dispatch-sync [:boot])
  (dev-setup)
  (mount-root))
