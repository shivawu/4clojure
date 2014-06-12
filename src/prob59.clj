; 59. Juxtaposition
(fn [& fs]
  (fn [& args]
    (map #(apply % args) fs)))

