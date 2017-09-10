(ns re.subs
  (:require [re-frame.core :as re-frame :refer [reg-sub]]))

;; -- Status ------------------------------------------------------------------

(reg-sub
  :failed
  (fn [db]
    (:failed db)))

;; -- Routing -----------------------------------------------------------------

(reg-sub
  :active-panel
  (fn [db]
    (:active-panel db)))
