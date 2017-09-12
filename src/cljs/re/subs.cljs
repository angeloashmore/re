(ns re.subs
  (:require [re-frame.core :refer [reg-sub]]))

;; -- status

(reg-sub
  :failed
  (fn [db]
    (:failed db)))

;; -- routing

(reg-sub
  :active-panel
  (fn [db]
    (:active-panel db)))

;; -- subreddit

(reg-sub
  :subreddit
  (fn [db]
    (:subreddit db)))
