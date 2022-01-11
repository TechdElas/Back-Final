CRIAR TABELA `tb_postagem` (
	`id_postagem` bigint NÃO NULO,
	`titulo` varchar (30) NOT NULL AUTO_INCREMENT,
	`texto` varchar (255) NOT NULL AUTO_INCREMENT,
	`data` TIMESTAMP NOT NULL AUTO_INCREMENT,
	`midia` varchar (255) NOT NULL AUTO_INCREMENT,
	`fk_usuario_id` bigint NOT NULL AUTO_INCREMENT,
	`fk_tema_id` bigint NOT NULL AUTO_INCREMENT,
	CHAVE PRIMÁRIA (`id_postagem`)
);

CRIAR TABELA `tb_usuario` (
	`id__usuario` bigint NOT NULL AUTO_INCREMENT,
	`nome` varchar (255) NOT NULL AUTO_INCREMENT,
	`email` varchar (55) NOT NULL AUTO_INCREMENT,
	`senha` varchar NOT NULL AUTO_INCREMENT,
	CHAVE PRIMÁRIA (`id__usuario`)
);

CRIAR TABELA `tb_tema` (
	`id_tema` bigint NOT NULL AUTO_INCREMENT,
	`nome_tema` varchar (40) NÃO NULO AUTO_INCREMENT,
	`sobre` varchar (300) NOT NULL AUTO_INCREMENT,
	`img_devs` varchar (255) NÃO NULO AUTO_INCREMENT,
	CHAVE PRIMÁRIA (`id_tema`)
);

ALTER TABLE `tb_postagem` ADD CONSTRAINT` tb_postagem_fk0` FOREIGN KEY (`fk_usuario_id`) REFERÊNCIAS` tb_usuario` (`id__usuario`);

ALTER TABLE `tb_postagem` ADD CONSTRAINT` tb_postagem_fk1` FOREIGN KEY (`fk_tema_id`) REFERÊNCIAS` tb_tema` (`id_tema`);




