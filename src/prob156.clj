; 156. Map Defaults
(fn [dv keys]
  (into {}
    (for [k keys] [k dv])))

