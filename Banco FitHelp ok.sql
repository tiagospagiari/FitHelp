DROP TABLE IF EXISTS TIPO_DIETA_REFEICOES CASCADE;
DROP TABLE IF EXISTS PREFERENCIAS_ALIMENTOS CASCADE;
DROP TABLE IF EXISTS ALIMENTO_REFEICAO CASCADE;
DROP TABLE IF EXISTS PREFERENCIA CASCADE;
DROP TABLE IF EXISTS ALIMENTO CASCADE;
DROP TABLE IF EXISTS REFEICAO CASCADE;
DROP TABLE IF EXISTS DIETA CASCADE;
DROP TABLE IF EXISTS AVALIACAO_FISICA CASCADE;
DROP TABLE IF EXISTS MENSAGEM CASCADE;
DROP TABLE IF EXISTS POST CASCADE;
DROP TABLE IF EXISTS SEGUIR CASCADE;
DROP TABLE IF EXISTS PESSOA CASCADE;
DROP TABLE IF EXISTS TIPO_DIETA CASCADE;
DROP TABLE IF EXISTS TIPO_ALIMENTO CASCADE;


	create table ALIMENTO (
		id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(255) UNIQUE,
        carboidratos DOUBLE,
        gorduras DOUBLE,
        proteinas DOUBLE,
        porcao VARCHAR(255),
        calorias DOUBLE,
        dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP
    );
    
        create table PESSOA (
		id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(255),
        sexo VARCHAR(255),
        nascimento DATE,
        login VARCHAR(255),
        senha VARCHAR(255),
        tipousuario VARCHAR(20),
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP
    );
    
	create table TIPO_ALIMENTO (
		id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(255) UNIQUE
    );
    
    create table PREFERENCIA (
        idpessoa INT,
        idalimento INT,
        idtipoalimento INT,
        PRIMARY KEY (idpessoa,idalimento,idtipoalimento),
        FOREIGN KEY (idpessoa) REFERENCES PESSOA(id),
        FOREIGN KEY (idalimento) REFERENCES ALIMENTO(id),
        FOREIGN KEY (idtipoalimento) REFERENCES TIPO_ALIMENTO(id)
    );
    
    create table TIPO_DIETA (
		id INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(255),
        carboidrato DOUBLE,
        proteina DOUBLE,
        gordura DOUBLE,
        objetivo VARCHAR(255),
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP
    );
    
    
    create table AVALIACAO_FISICA(
		id INT PRIMARY KEY AUTO_INCREMENT,
        idpessoa INT NOT NULL,
        peso DOUBLE,
        sexo VARCHAR(40),
        altura DOUBLE,
        idade INT,
        pescoco DOUBLE,
        cintura DOUBLE,
        quadril DOUBLE,
        fatoratividade DOUBLE,
        imc DOUBLE,
        tmb DOUBLE,
        bf DOUBLE,
        massaGorda DOUBLE,
        massaMagra DOUBLE,
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (idpessoa) REFERENCES PESSOA(id)
    );
    
    
        create table DIETA (
		id INT PRIMARY KEY AUTO_INCREMENT,
        idpessoa INT NOT NULL,
        idavaliacaofisica INT NOT NULL,
        idtipodieta INT NULL,
        objetivo VARCHAR(255),
        calorias DOUBLE,
        numerorefeicoes INT,
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (idpessoa) REFERENCES PESSOA(id),
        FOREIGN KEY (idavaliacaofisica) REFERENCES AVALIACAO_FISICA(id),
        FOREIGN KEY (idtipodieta) REFERENCES TIPO_DIETA(id)
        
    );
    
    
    
    create table REFEICAO (
		id INT PRIMARY KEY AUTO_INCREMENT,
        iddieta INT NOT NULL,
        carboidrato DOUBLE,
        proteina DOUBLE,
        gordura DOUBLE,
        calorias DOUBLE,
        nomerefeicao VARCHAR(255),
        datacriacao DATETIME DEFAULT NOW(),
        FOREIGN KEY (iddieta) REFERENCES DIETA(id)
        
    );
    
    
    create table ALIMENTO_REFEICAO(
		id INT PRIMARY KEY AUTO_INCREMENT,
        idrefeicao INT NOT NULL,
        idalimento INT NOT NULL,
        porcao DOUBLE,
        carboidratos DOUBLE,
        proteinas DOUBLE,
        gorduras DOUBLE,
        calorias double,
        dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (idrefeicao) REFERENCES REFEICAO(id),
        FOREIGN KEY (idalimento) REFERENCES ALIMENTO(id)
	);
    
	
    
    create table MENSAGEM (
		id INT PRIMARY KEY AUTO_INCREMENT,
        idpessoaorigem INT NOT NULL,
        idpessoadestino INT NOT NULL,
        mensagem VARCHAR(255),
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (idpessoaorigem) REFERENCES PESSOA(id),
		FOREIGN KEY (idpessoadestino) REFERENCES PESSOA(id)
    );
    
    create table POST (
		id INT PRIMARY KEY AUTO_INCREMENT,
        idpessoa INT NOT NULL,
        conteudo VARCHAR(255),
        datacriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (idpessoa) REFERENCES PESSOA(id)
    );
    
    create table SEGUIR (
		id INT PRIMARY KEY AUTO_INCREMENT,
        idorigem INT NOT NULL,
        idseguindo INT NOT NULL,
        datacriacao DATETIME DEFAULT NOW(),
        FOREIGN KEY (idseguindo) REFERENCES PESSOA(id),
           FOREIGN KEY (idorigem) REFERENCES PESSOA(id)
    );

    
    create table TIPO_DIETA_REFEICOES (
		idtipodieta INT NOT NULL,
        idrefeicao INT NOT NULL,
        PRIMARY KEY (idtipodieta, idrefeicao),
        FOREIGN KEY (idtipodieta) REFERENCES TIPO_DIETA(id),
        FOREIGN KEY (idrefeicao) REFERENCES REFEICAO(id)
    );
    
		INSERT INTO bd.tipo_dieta (id,nome,carboidrato,proteina,gordura) VALUES 
		(1,"Equilibrada",40,30,30),
		(2,"Low Carb", 30, 50, 20),
		(3, "Cetogênica", 15, 15, 70);
        
        INSERT INTO bd.TIPO_ALIMENTO (id, nome) VALUES
        (1, "carboidratos"),
        (2, "proteinas"),
        (3, "gorduras");
        
        SELECT * FROM bd.tipo_alimento;
        
        /* INTO pessoa (id, nome, sexo, login) VALUES (1, "NOME 1", "MASCULINO", "USER_LOGIN");
        
        INSERT INTO alimento (id, nome, carboidratos, gorduras, proteinas, porcao) VALUES (1, "NOME ALIMENTO 1", 10.5, 20, 30, "100g");

        INSERT INTO preferencia (idpessoa, idalimento, idtipoalimento) VALUES (1, 1, 2);*/
        
        SELECT alimentoid, alimentonome, carboidratos, proteinas, gorduras, porcao, calorias, tipoalimentoid, tipoalimentonome from 
        (SELECT alimento.id as alimentoid, alimento.nome as alimentonome, alimento.carboidratos, alimento.proteinas, alimento.gorduras, alimento.porcao, alimento.calorias, tipo_alimento.id as tipoalimentoid, tipo_alimento.nome as tipoalimentonome FROM preferencia, alimento, tipo_alimento 
        where preferencia.idpessoa = 1 AND preferencia.idtipoalimento = tipo_alimento.id AND preferencia.idalimento = alimento.id) as ALIMENTO_PREFERENCIA_TIPOALIMENTO;
        
        /*INSERT INTO alimento (id, nome, carboidratos, gorduras, proteinas, porcao) VALUES (101, "NOME ALIMENTO 20", 10.5, 20, 30, "100g");
        INSERT INTO preferencia (idpessoa, idalimento, idtipoalimento) VALUES (1,101,3);
        SELECT * FROM preferencia;*/
        
    