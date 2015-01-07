(ns {{ns-name}}.core
  (:require [clojure.string :as string]
            [json-html.core :refer [edn->hiccup]]
            [reagent.core :as r]
            [reagent-forms.core :as forms]
            [{{ns-name}}.session :as session :refer [global-state]]
            [{{ns-name}}.routes :as routes]
            [{{ns-name}}.views.common :as common]
            [{{ns-name}}.views.app-page :as app]
            [{{ns-name}}.views.user-page :as user]))

;;; This template began as my playground for learning what was
;;; available. It contains lots of example code that you probably
;;; don't want. So, the best way to use this for a new project is to
;;; first "lein new {{ns-name}}-template" your project, and then remove
;;; all the bits you don't want.




(defn page-dom []
  [:div.container
   [common/header]
   [(global-state :current-page)]])

(defn page-component []
  (r/create-class {:component-will-mount routes/app-routes
                   :render page-dom}))


;;; Main entry point. Render the current page.
(defn main []
  (r/render-component [page-component] (.getElementById js/document "app")))
