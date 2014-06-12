; 125. Gas' Quinundrum
(fn []
  (let [prog '(fn []
                (let [prog nil]
                  (str
                    (cons 'fn
                      (cons '[]
                        (list
                          (list* 'let ['prog (list 'quote prog)] (list (-> prog (nth 2) (nth 2))))))))))]
    (str
      (cons 'fn
        (cons '[]
          (list
            (list* 'let ['prog (list 'quote prog)] (list (-> prog (nth 2) (nth 2))))))))))

