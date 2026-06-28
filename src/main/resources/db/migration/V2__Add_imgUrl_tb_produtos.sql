-- Migration para adicionar a coluna de Imagens

ALTER TABLE tb_produtos
ADD COLUMN img_url VARCHAR(1000);

