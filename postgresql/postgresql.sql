--
-- PostgreSQL database dump
--

-- Dumped from database version 12.6 (Debian 12.6-1.pgdg100+1)
-- Dumped by pg_dump version 12.7 (Ubuntu 12.7-0ubuntu0.20.04.1)

-- Started on 2021-07-13 18:23:55 WIB

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

-- CREATE SCHEMA public;


-- ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2919 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 19750)
-- Name: child; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.child (
    id character varying(255) NOT NULL,
    birthdate timestamp without time zone,
    name character varying(255),
    parent_id character varying(255)
);


-- ALTER TABLE public.child OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 19758)
-- Name: parent; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parent (
    id character varying(255) NOT NULL,
    name character varying(255)
);


-- ALTER TABLE public.parent OWNER TO postgres;

--
-- TOC entry 2912 (class 0 OID 19750)
-- Dependencies: 202
-- Data for Name: child; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.child (id, birthdate, name, parent_id) FROM stdin;
2984bf35-6796-441a-b527-f4283a1cd91c	1906-07-14 00:00:00	Joe	47dba31b-54af-4a5f-b0fa-604eab2b5815
a57e3eb2-06e2-496b-9c38-4e5adc8f23b2	1906-07-16 00:00:00	Phill	47dba31b-54af-4a5f-b0fa-604eab2b5815
72d7ee38-dfa2-4bef-a131-9bcc23628666	1906-07-18 00:00:00	Kei	f36c8f9d-5d12-4a04-8af4-e078f6d908a8
64f84bb3-5474-47c1-b89a-9c751bd233c4	1906-07-19 00:00:00	Emma	f36c8f9d-5d12-4a04-8af4-e078f6d908a8
\.


--
-- TOC entry 2913 (class 0 OID 19758)
-- Dependencies: 203
-- Data for Name: parent; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parent (id, name) FROM stdin;
47dba31b-54af-4a5f-b0fa-604eab2b5815	Gunther
f36c8f9d-5d12-4a04-8af4-e078f6d908a8	Rob
\.


--
-- TOC entry 2782 (class 2606 OID 19757)
-- Name: child child_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.child
    ADD CONSTRAINT child_pkey PRIMARY KEY (id);


--
-- TOC entry 2784 (class 2606 OID 19765)
-- Name: parent parent_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parent
    ADD CONSTRAINT parent_pkey PRIMARY KEY (id);


--
-- TOC entry 2785 (class 2606 OID 19766)
-- Name: child fk7dag1cncltpyhoc2mbwka356h; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.child
    ADD CONSTRAINT fk7dag1cncltpyhoc2mbwka356h FOREIGN KEY (parent_id) REFERENCES public.parent(id);


-- Completed on 2021-07-13 18:23:55 WIB

--
-- PostgreSQL database dump complete
--

