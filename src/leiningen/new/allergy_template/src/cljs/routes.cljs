(ns {{ns-name}}.routes
  (:require   [secretary.core :as secretary :refer-macros [defroute]]
              [{{ns-name}}.session :as session :refer [global-put!]]
              [{{ns-name}}.views.pages :refer [pages]]
              [goog.events :as events]
              [goog.history.EventType :as EventType])
    (:import goog.History))



;;; Page manager for single-page-app with client-side routing.
;;; Mostly taken from reagent-cookbook
;;; (https://github.com/reagent-project/reagent-cookbook/tree/master/recipes/adding-a-page)



;; History
(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))
;; need to run this after routes have been defined


;; Routes
(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
    (global-put! :current-page (pages :home-page))
    (global-put! :nav "home"))

  (defroute "/about" []
    (global-put! :current-page (pages :about-page))
    (global-put! :nav "about"))

  (defroute "/new" []
    (global-put! :current-page (pages :new-page))
    (global-put! :nav "new"))

  (defroute "/user" []
    (global-put! :current-page (pages :user-page))
    (global-put! :nav "user"))

  (defroute "/app" []
    (global-put! :current-page (pages :app-page))
    (global-put! :nav "app"))

  (defroute "/dumper" []
    (global-put! :current-page (pages :dumper-page))
    (global-put! :nav "dumper"))

  (hook-browser-navigation!))
