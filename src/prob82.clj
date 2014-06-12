; 82. Word Chains
(fn [words]
  (let [step1? (fn [a b]
                 (let
                   [delete1 (fn [y]
                              (map #(str (subs y 0 %) (subs y (inc %))) (range (count y))))
                    delete-test (fn [x y]
                                  (some #(= x %) (delete1 y)))
                    diff-test (fn [x y]
                                (count (filter true? (map not= (seq x) (seq y)))))]
                   (case (- (count a) (count b))
                     1 (delete-test b a)
                     -1 (delete-test a b)
                     0 (= 1 (diff-test a b))
                     false)))
        conns (into {}
                (for [x words]
                  [x (set
                       (for [y words :when (step1? x y)] y))]))
        search (fn s [cur visited]
                 (if (= (count words) (count visited))
                   true
                   (let [nexts (remove #(contains? visited %) (get conns cur))]
                     (some true? (map #(s % (conj visited %)) nexts)))))]
    (boolean (some #(search % #{%}) words))))

