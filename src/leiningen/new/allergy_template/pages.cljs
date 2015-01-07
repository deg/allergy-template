(ns {{ns-name}}.views.pages
  (:require {{ns-name}}.views.home-page
            {{ns-name}}.views.about-page
            {{ns-name}}.views.new-page
            {{ns-name}}.views.user-page
            {{ns-name}}.views.app-page
            {{ns-name}}.views.dumper-page))

(def pages {:home-page   {{ns-name}}.views.home-page/page-dom
            :about-page  {{ns-name}}.views.about-page/page-dom
            :new-page    {{ns-name}}.views.new-page/page-dom
            :user-page   {{ns-name}}.views.user-page/page-dom
            :app-page    {{ns-name}}.views.app-page/page-dom
            :dumper-page {{ns-name}}.views.dumper-page/page-dom})
