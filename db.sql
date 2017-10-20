CREATE TABLE "company" (
"id"  SERIAL ,
"name" TEXT ,
"type" TEXT NOT NULL DEFAULT 'BREWERY' ,
"id_storage" INTEGER ,
"id_user" INTEGER ,
PRIMARY KEY ("id")
);

CREATE TABLE "storage" (
"id"  SERIAL ,
"id_resource" INTEGER ,
"amount" INTEGER NOT NULL DEFAULT 1 ,
PRIMARY KEY ("id")
);

CREATE TABLE "resource" (
"id"  SERIAL ,
"type" TEXT NOT NULL DEFAULT 'BEER' ,
"quality" BIGINT NOT NULL DEFAULT 1 ,
PRIMARY KEY ("id")
);

CREATE TABLE "offer" (
"id"  SERIAL ,
"id_company" INTEGER ,
"id_resource" INTEGER ,
"amount" INTEGER NOT NULL DEFAULT 1 ,
PRIMARY KEY ("id")
);

CREATE TABLE "user" (
"id"  SERIAL ,
"username" TEXT NOT NULL ,
"publicId" TEXT NOT NULL ,
PRIMARY KEY ("id")
);

ALTER TABLE "company" ADD FOREIGN KEY ("id_storage") REFERENCES "storage" ("id");
ALTER TABLE "company" ADD FOREIGN KEY ("id_user") REFERENCES "user" ("id");
ALTER TABLE "storage" ADD FOREIGN KEY ("id_resource") REFERENCES "resource" ("id");
ALTER TABLE "offer" ADD FOREIGN KEY ("id_company") REFERENCES "company" ("id");
ALTER TABLE "offer" ADD FOREIGN KEY ("id_resource") REFERENCES "resource" ("id");