(ns re.events
  (:require [re-frame.core :as re-frame :refer [reg-event-db]]))

;; -- Status ------------------------------------------------------------------

(reg-event-db
  :app-failure
  (fn [db _]
    (assoc db :failed true)))

;; -- Routing -----------------------------------------------------------------

(reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))
