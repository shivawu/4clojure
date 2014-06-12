; 91. Graph Connectiviy
(fn [g]
  (let [nodes (distinct (flatten (for [[a b] g] [a b])))
        connected-comp (fn find-cc [c cc]
                         (let [nexts (for [[x y] g :when (= x c) :when (not (contains? cc y))] y)
                               ncc (into cc nexts)]
                           (reduce into ncc (map #(find-cc % ncc) nexts))))]
    (= (count (connected-comp (first nodes) #{(first nodes)})) (count nodes))))

