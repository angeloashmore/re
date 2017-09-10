(ns re.views
  (:require [re-frame.core :as re-frame]
            [re.panels.home :as home]
            [re.panels.about :as about]
            [re.components.header :as header]
            [re.components.footer :as footer]))

(defmulti panels identity)
(defmethod panels :home-panel [] [home/main])
(defmethod panels :about-panel [] [about/main])
(defmethod panels :default [] [:div])

(defn main-panel
  []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div.sans-serif.ph3.pv2.mw8.center
       [header/main]
       (panels @active-panel)
       [footer/main]])))
