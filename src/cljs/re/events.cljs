(ns re.events
  (:require [re-frame.core :as re-frame :refer [reg-event-db]]))

;; -- status

(reg-event-db
  :app-failure
  (fn [db _]
    (assoc db :failed true)))

;; -- routing

(reg-event-db
  :set-active-panel
  (fn [db [_ active-panel]]
    (assoc db :active-panel active-panel)))

;; -- subreddit

(reg-event-db
  :set-subreddit
  (fn [db [_ subreddit]]
    (assoc db :subreddit subreddit)))
