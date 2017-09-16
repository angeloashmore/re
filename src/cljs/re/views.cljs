(ns re.views
  (:require [re-frame.core :as re-frame]
            [re.panels.home :as home]
            [re.panels.post :as post]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home/main])
(defmethod panels :post-panel [] [post/main])
(defmethod panels :default [] [:div])

(defn main-panel
  []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      (panels @active-panel))))
