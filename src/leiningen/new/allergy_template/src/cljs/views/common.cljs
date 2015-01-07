(ns {{ns-name}}.views.common
  (:require  [{{ns-name}}.session :as session :refer [global-state]]))

(defn active? [state val]
  (if (= state val) "active" ""))

(defn header []
  [:div.page-header.row
   [:div.col-md-6
    [:ul.nav.nav-pills
     [:li {:class (active? (global-state :nav) "home")}   [:a {:href "#/"} [:span [:i.fa.fa-home] " Home"]]]
     [:li {:class (active? (global-state :nav) "about")}  [:a {:href "#/about"} "About"]]
     [:li {:class (active? (global-state :nav) "new")}    [:a {:href "#/new"} "New Page"]]
     [:li {:class (active? (global-state :nav) "user")}   [:a {:href "#/user"} "User Page"]]
     [:li {:class (active? (global-state :nav) "app")}    [:a {:href "#/app"} "Our App"]]
     [:li {:class (active? (global-state :nav) "dumper")} [:a {:href "#/dumper"} "Debug Dumper"]]]]])
