--- clean up ---
DELETE FROM COMMENT;
DELETE FROM POST;
DELETE FROM USER_;


--- users ---
INSERT INTO USER_ (ID_, EMAIL_, PASSWORD_) VALUES
  (42, 'matthias', 'cbe0a0c3468f2d73f6789fd3eec034e5a82f2b0059df560492d4a59c51e8fa8fea9d2b018bcc0fc4560b7780de4c029675c927361db225c65796b427613751a2') -- supersecure
