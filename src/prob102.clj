; 102. intoCamelCase
(fn [s]
  (let [toks (.split s "-")
        norms (map #(str (.toUpperCase (subs % 0 1)) (subs % 1)) toks)
        pascal (apply str norms)]
    (str (.toLowerCase (subs pascal 0 1)) (subs pascal 1))))

