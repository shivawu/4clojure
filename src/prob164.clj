; 164. Language of a DFA
(fn [{states :states,
      alphabet :alphabet,
      start :start,
      accepts :accepts
      trans :transitions}]
  (let [expand (fn [q]
                 (for [[state path] q
                       :let [t (trans state)]
                       :when t
                       a alphabet
                       :when (t a)]
                   [(t a) (conj path a)]))
        all-states (take-while not-empty (iterate expand [[start []]]))]
    (for [q all-states
          [state path] q
          :when (accepts state)]
      (apply str path))))

