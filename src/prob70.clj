; 70. Word Sorting
(comp
  (partial sort-by clojure.string/lower-case)
  #(clojure.string/split (clojure.string/replace % #"[!.?]" "") #"\s+"))

