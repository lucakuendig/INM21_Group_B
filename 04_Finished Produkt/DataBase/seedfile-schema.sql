--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: adresse; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE adresse (
    id integer NOT NULL,
    strasse character varying(255),
    ort character varying(255),
    plz integer
);


ALTER TABLE adresse OWNER TO mangeldb;

--
-- Name: arbeitstyp; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE arbeitstyp (
    id integer NOT NULL,
    bezeichnung character varying(255)
);


ALTER TABLE arbeitstyp OWNER TO mangeldb;

--
-- Name: bauherr; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE bauherr (
    id integer NOT NULL,
    fkadresse_id integer
);


ALTER TABLE bauherr OWNER TO mangeldb;

--
-- Name: gumitarbeiter; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE gumitarbeiter (
    id integer NOT NULL,
    fklogin_id integer
);


ALTER TABLE gumitarbeiter OWNER TO mangeldb;

--
-- Name: login; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE login (
    id integer NOT NULL,
    benutzername character varying(255),
    email character varying(255),
    passwort character varying(255),
    fkrolle_id integer
);


ALTER TABLE login OWNER TO mangeldb;

--
-- Name: mangel; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE mangel (
    id integer NOT NULL,
    abschlusszeit timestamp without time zone,
    beschreibung character varying(255),
    bezeichnung character varying(255),
    erfassungszeit timestamp without time zone,
    faelligkeitsdatum date,
    fklogin_id integer,
    fkmangelstatus_id integer,
    fkprojekt_id integer
);


ALTER TABLE mangel OWNER TO mangeldb;

--
-- Name: mangelstatus; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE mangelstatus (
    id integer NOT NULL,
    bezeichnung character varying(255)
);


ALTER TABLE mangelstatus OWNER TO mangeldb;

--
-- Name: meldung; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE meldung (
    id integer NOT NULL,
    quittiert boolean,
    text character varying(255),
    zeitpunkt date,
    fkmeldungstyp_id integer,
    fklogin_id integer,
    fkmangel_id integer
);


ALTER TABLE meldung OWNER TO mangeldb;

--
-- Name: meldungstyp; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE meldungstyp (
    id integer NOT NULL,
    bezeichnung character varying(255)
);


ALTER TABLE meldungstyp OWNER TO mangeldb;

--
-- Name: objekttyp; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE objekttyp (
    id integer NOT NULL,
    bezeichnung character varying(255)
);


ALTER TABLE objekttyp OWNER TO mangeldb;

--
-- Name: person; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE person (
    id integer NOT NULL,
    dtype character varying(31),
    nachname character varying(255),
    telefon character varying(255),
    vorname character varying(255)
);


ALTER TABLE person OWNER TO mangeldb;

--
-- Name: plz; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE plz (
    ort character varying(255) NOT NULL,
    plz integer NOT NULL
);


ALTER TABLE plz OWNER TO mangeldb;

--
-- Name: projekt; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE projekt (
    id integer NOT NULL,
    beschreibung character varying(255),
    bezeichnung character varying(255),
    enddatum date,
    faelligkeitsdatum date,
    startdatum date,
    fkarbeitstyp_id integer,
    fkobjekttyp_id integer,
    fkprojektstatus_id integer,
    fkadresse_id integer
);


ALTER TABLE projekt OWNER TO mangeldb;

--
-- Name: projekt_bauherr; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE projekt_bauherr (
    projekt_id integer NOT NULL,
    fkbauherr_id integer NOT NULL
);


ALTER TABLE projekt_bauherr OWNER TO mangeldb;

--
-- Name: projektgumitarbeiter; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE projektgumitarbeiter (
    id integer NOT NULL,
    enddatum date,
    startdatum date,
    fkmitarbeiter_id integer,
    fkprojekt_id integer
);


ALTER TABLE projektgumitarbeiter OWNER TO mangeldb;

--
-- Name: projektstatus; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE projektstatus (
    id integer NOT NULL,
    bezeichnung character varying(255)
);


ALTER TABLE projektstatus OWNER TO mangeldb;

--
-- Name: projektsumitarbeiter; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE projektsumitarbeiter (
    id integer NOT NULL,
    enddatum date,
    startdatum date,
    fkmitarbeiter_id integer,
    fkprojekt_id integer
);


ALTER TABLE projektsumitarbeiter OWNER TO mangeldb;

--
-- Name: rolle; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE rolle (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE rolle OWNER TO mangeldb;

--
-- Name: sequence; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE sequence (
    seq_name character varying(50) NOT NULL,
    seq_count numeric(38,0)
);


ALTER TABLE sequence OWNER TO mangeldb;

--
-- Name: subunternehmen; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE subunternehmen (
    id integer NOT NULL,
    name character varying(255),
    telefon character varying(255),
    fkadresse_id integer
);


ALTER TABLE subunternehmen OWNER TO mangeldb;

--
-- Name: sumitarbeiter; Type: TABLE; Schema: public; Owner: mangeldb; Tablespace: 
--

CREATE TABLE sumitarbeiter (
    id integer NOT NULL,
    fklogin_id integer,
    fksubunternehmen_id integer
);


ALTER TABLE sumitarbeiter OWNER TO mangeldb;

--
-- Name: adresse_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY adresse
    ADD CONSTRAINT adresse_pkey PRIMARY KEY (id);


--
-- Name: arbeitstyp_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY arbeitstyp
    ADD CONSTRAINT arbeitstyp_pkey PRIMARY KEY (id);


--
-- Name: bauherr_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY bauherr
    ADD CONSTRAINT bauherr_pkey PRIMARY KEY (id);


--
-- Name: gumitarbeiter_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY gumitarbeiter
    ADD CONSTRAINT gumitarbeiter_pkey PRIMARY KEY (id);


--
-- Name: login_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- Name: mangel_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY mangel
    ADD CONSTRAINT mangel_pkey PRIMARY KEY (id);


--
-- Name: mangelstatus_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY mangelstatus
    ADD CONSTRAINT mangelstatus_pkey PRIMARY KEY (id);


--
-- Name: meldung_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY meldung
    ADD CONSTRAINT meldung_pkey PRIMARY KEY (id);


--
-- Name: meldungstyp_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY meldungstyp
    ADD CONSTRAINT meldungstyp_pkey PRIMARY KEY (id);


--
-- Name: objekttyp_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY objekttyp
    ADD CONSTRAINT objekttyp_pkey PRIMARY KEY (id);


--
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: plz_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY plz
    ADD CONSTRAINT plz_pkey PRIMARY KEY (ort, plz);


--
-- Name: projekt_bauherr_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY projekt_bauherr
    ADD CONSTRAINT projekt_bauherr_pkey PRIMARY KEY (projekt_id, fkbauherr_id);


--
-- Name: projekt_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY projekt
    ADD CONSTRAINT projekt_pkey PRIMARY KEY (id);


--
-- Name: projektgumitarbeiter_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY projektgumitarbeiter
    ADD CONSTRAINT projektgumitarbeiter_pkey PRIMARY KEY (id);


--
-- Name: projektstatus_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY projektstatus
    ADD CONSTRAINT projektstatus_pkey PRIMARY KEY (id);


--
-- Name: projektsumitarbeiter_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY projektsumitarbeiter
    ADD CONSTRAINT projektsumitarbeiter_pkey PRIMARY KEY (id);


--
-- Name: rolle_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY rolle
    ADD CONSTRAINT rolle_pkey PRIMARY KEY (id);


--
-- Name: sequence_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY sequence
    ADD CONSTRAINT sequence_pkey PRIMARY KEY (seq_name);


--
-- Name: subunternehmen_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY subunternehmen
    ADD CONSTRAINT subunternehmen_pkey PRIMARY KEY (id);


--
-- Name: sumitarbeiter_pkey; Type: CONSTRAINT; Schema: public; Owner: mangeldb; Tablespace: 
--

ALTER TABLE ONLY sumitarbeiter
    ADD CONSTRAINT sumitarbeiter_pkey PRIMARY KEY (id);


--
-- Name: fk_adresse_ort; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY adresse
    ADD CONSTRAINT fk_adresse_ort FOREIGN KEY (ort, plz) REFERENCES plz(ort, plz);


--
-- Name: fk_bauherr_fkadresse_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY bauherr
    ADD CONSTRAINT fk_bauherr_fkadresse_id FOREIGN KEY (fkadresse_id) REFERENCES adresse(id);


--
-- Name: fk_bauherr_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY bauherr
    ADD CONSTRAINT fk_bauherr_id FOREIGN KEY (id) REFERENCES person(id);


--
-- Name: fk_gumitarbeiter_fklogin_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY gumitarbeiter
    ADD CONSTRAINT fk_gumitarbeiter_fklogin_id FOREIGN KEY (fklogin_id) REFERENCES login(id);


--
-- Name: fk_gumitarbeiter_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY gumitarbeiter
    ADD CONSTRAINT fk_gumitarbeiter_id FOREIGN KEY (id) REFERENCES person(id);


--
-- Name: fk_login_fkrolle_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY login
    ADD CONSTRAINT fk_login_fkrolle_id FOREIGN KEY (fkrolle_id) REFERENCES rolle(id);


--
-- Name: fk_mangel_fklogin_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY mangel
    ADD CONSTRAINT fk_mangel_fklogin_id FOREIGN KEY (fklogin_id) REFERENCES login(id);


--
-- Name: fk_mangel_fkmangelstatus_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY mangel
    ADD CONSTRAINT fk_mangel_fkmangelstatus_id FOREIGN KEY (fkmangelstatus_id) REFERENCES mangelstatus(id);


--
-- Name: fk_mangel_fkprojekt_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY mangel
    ADD CONSTRAINT fk_mangel_fkprojekt_id FOREIGN KEY (fkprojekt_id) REFERENCES projekt(id);


--
-- Name: fk_meldung_fklogin_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY meldung
    ADD CONSTRAINT fk_meldung_fklogin_id FOREIGN KEY (fklogin_id) REFERENCES login(id);


--
-- Name: fk_meldung_fkmangel_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY meldung
    ADD CONSTRAINT fk_meldung_fkmangel_id FOREIGN KEY (fkmangel_id) REFERENCES mangel(id);


--
-- Name: fk_meldung_fkmeldungstyp_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY meldung
    ADD CONSTRAINT fk_meldung_fkmeldungstyp_id FOREIGN KEY (fkmeldungstyp_id) REFERENCES meldungstyp(id);


--
-- Name: fk_projekt_bauherr_fkbauherr_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt_bauherr
    ADD CONSTRAINT fk_projekt_bauherr_fkbauherr_id FOREIGN KEY (fkbauherr_id) REFERENCES person(id);


--
-- Name: fk_projekt_bauherr_projekt_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt_bauherr
    ADD CONSTRAINT fk_projekt_bauherr_projekt_id FOREIGN KEY (projekt_id) REFERENCES projekt(id);


--
-- Name: fk_projekt_fkadresse_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt
    ADD CONSTRAINT fk_projekt_fkadresse_id FOREIGN KEY (fkadresse_id) REFERENCES adresse(id);


--
-- Name: fk_projekt_fkarbeitstyp_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt
    ADD CONSTRAINT fk_projekt_fkarbeitstyp_id FOREIGN KEY (fkarbeitstyp_id) REFERENCES arbeitstyp(id);


--
-- Name: fk_projekt_fkobjekttyp_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt
    ADD CONSTRAINT fk_projekt_fkobjekttyp_id FOREIGN KEY (fkobjekttyp_id) REFERENCES objekttyp(id);


--
-- Name: fk_projekt_fkprojektstatus_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projekt
    ADD CONSTRAINT fk_projekt_fkprojektstatus_id FOREIGN KEY (fkprojektstatus_id) REFERENCES projektstatus(id);


--
-- Name: fk_projektgumitarbeiter_fkmitarbeiter_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projektgumitarbeiter
    ADD CONSTRAINT fk_projektgumitarbeiter_fkmitarbeiter_id FOREIGN KEY (fkmitarbeiter_id) REFERENCES person(id);


--
-- Name: fk_projektgumitarbeiter_fkprojekt_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projektgumitarbeiter
    ADD CONSTRAINT fk_projektgumitarbeiter_fkprojekt_id FOREIGN KEY (fkprojekt_id) REFERENCES projekt(id);


--
-- Name: fk_projektsumitarbeiter_fkmitarbeiter_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projektsumitarbeiter
    ADD CONSTRAINT fk_projektsumitarbeiter_fkmitarbeiter_id FOREIGN KEY (fkmitarbeiter_id) REFERENCES person(id);


--
-- Name: fk_projektsumitarbeiter_fkprojekt_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY projektsumitarbeiter
    ADD CONSTRAINT fk_projektsumitarbeiter_fkprojekt_id FOREIGN KEY (fkprojekt_id) REFERENCES projekt(id);


--
-- Name: fk_subunternehmen_fkadresse_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY subunternehmen
    ADD CONSTRAINT fk_subunternehmen_fkadresse_id FOREIGN KEY (fkadresse_id) REFERENCES adresse(id);


--
-- Name: fk_sumitarbeiter_fklogin_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY sumitarbeiter
    ADD CONSTRAINT fk_sumitarbeiter_fklogin_id FOREIGN KEY (fklogin_id) REFERENCES login(id);


--
-- Name: fk_sumitarbeiter_fksubunternehmen_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY sumitarbeiter
    ADD CONSTRAINT fk_sumitarbeiter_fksubunternehmen_id FOREIGN KEY (fksubunternehmen_id) REFERENCES subunternehmen(id);


--
-- Name: fk_sumitarbeiter_id; Type: FK CONSTRAINT; Schema: public; Owner: mangeldb
--

ALTER TABLE ONLY sumitarbeiter
    ADD CONSTRAINT fk_sumitarbeiter_id FOREIGN KEY (id) REFERENCES person(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

