INSERT INTO `user` (idx,id,password) VALUES
	 (1,'temp','123'),
	 (2,'hong','12345'); 

INSERT INTO `post` (idx,title,content, user_idx) VALUES
	 (1,'첫번째','안녕하세요',1),
	 (2,'두번째','반갑습니다',1),
	 (3,'세번째','뉴비입니다',2);