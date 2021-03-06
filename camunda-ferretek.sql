PGDMP                         y            camunda_ferretek    13.0    13.0 ,    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    87924    camunda_ferretek    DATABASE     n   CREATE DATABASE camunda_ferretek WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';
     DROP DATABASE camunda_ferretek;
                postgres    false            ?            1259    87940    categoria_producto    TABLE     _   CREATE TABLE public.categoria_producto (
    capr_id integer NOT NULL,
    capr_nombre text
);
 &   DROP TABLE public.categoria_producto;
       public         heap    postgres    false            ?            1259    87938    categoria_producto_capr_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.categoria_producto_capr_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.categoria_producto_capr_id_seq;
       public          postgres    false    201            ?           0    0    categoria_producto_capr_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.categoria_producto_capr_id_seq OWNED BY public.categoria_producto.capr_id;
          public          postgres    false    200            ?            1259    88000    cliente    TABLE     ?   CREATE TABLE public.cliente (
    clien_id integer NOT NULL,
    clien_cedula text,
    clien_nombres text,
    clien_apellidos text,
    clien_correo text,
    clien_telef text
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            ?            1259    87998    cliente_clien_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.cliente_clien_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cliente_clien_id_seq;
       public          postgres    false    207            ?           0    0    cliente_clien_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cliente_clien_id_seq OWNED BY public.cliente.clien_id;
          public          postgres    false    206            ?            1259    88018    detalle_pedido    TABLE     ?   CREATE TABLE public.detalle_pedido (
    depe_id integer NOT NULL,
    orde_id integer,
    prod_id integer,
    depe_cantidad integer
);
 "   DROP TABLE public.detalle_pedido;
       public         heap    postgres    false            ?            1259    88016    detalle_pedido_depe_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.detalle_pedido_depe_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.detalle_pedido_depe_id_seq;
       public          postgres    false    209            ?           0    0    detalle_pedido_depe_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.detalle_pedido_depe_id_seq OWNED BY public.detalle_pedido.depe_id;
          public          postgres    false    208            ?            1259    87984    orden    TABLE     ?   CREATE TABLE public.orden (
    orde_id integer NOT NULL,
    clien_id integer,
    orde_fecha date,
    orde_direccion_env text,
    orde_costo_env double precision
);
    DROP TABLE public.orden;
       public         heap    postgres    false            ?            1259    87982    orden_orde_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.orden_orde_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.orden_orde_id_seq;
       public          postgres    false    205            ?           0    0    orden_orde_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.orden_orde_id_seq OWNED BY public.orden.orde_id;
          public          postgres    false    204            ?            1259    87951    producto    TABLE     ?   CREATE TABLE public.producto (
    prod_id integer NOT NULL,
    prod_nombre text,
    prod_precio double precision,
    prod_stock integer,
    capr_id integer
);
    DROP TABLE public.producto;
       public         heap    postgres    false            ?            1259    87949    producto_prod_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.producto_prod_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.producto_prod_id_seq;
       public          postgres    false    203            ?           0    0    producto_prod_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.producto_prod_id_seq OWNED BY public.producto.prod_id;
          public          postgres    false    202            >           2604    87943    categoria_producto capr_id    DEFAULT     ?   ALTER TABLE ONLY public.categoria_producto ALTER COLUMN capr_id SET DEFAULT nextval('public.categoria_producto_capr_id_seq'::regclass);
 I   ALTER TABLE public.categoria_producto ALTER COLUMN capr_id DROP DEFAULT;
       public          postgres    false    201    200    201            A           2604    88003    cliente clien_id    DEFAULT     t   ALTER TABLE ONLY public.cliente ALTER COLUMN clien_id SET DEFAULT nextval('public.cliente_clien_id_seq'::regclass);
 ?   ALTER TABLE public.cliente ALTER COLUMN clien_id DROP DEFAULT;
       public          postgres    false    207    206    207            B           2604    88021    detalle_pedido depe_id    DEFAULT     ?   ALTER TABLE ONLY public.detalle_pedido ALTER COLUMN depe_id SET DEFAULT nextval('public.detalle_pedido_depe_id_seq'::regclass);
 E   ALTER TABLE public.detalle_pedido ALTER COLUMN depe_id DROP DEFAULT;
       public          postgres    false    209    208    209            @           2604    87987    orden orde_id    DEFAULT     n   ALTER TABLE ONLY public.orden ALTER COLUMN orde_id SET DEFAULT nextval('public.orden_orde_id_seq'::regclass);
 <   ALTER TABLE public.orden ALTER COLUMN orde_id DROP DEFAULT;
       public          postgres    false    205    204    205            ?           2604    87954    producto prod_id    DEFAULT     t   ALTER TABLE ONLY public.producto ALTER COLUMN prod_id SET DEFAULT nextval('public.producto_prod_id_seq'::regclass);
 ?   ALTER TABLE public.producto ALTER COLUMN prod_id DROP DEFAULT;
       public          postgres    false    202    203    203            ?          0    87940    categoria_producto 
   TABLE DATA           B   COPY public.categoria_producto (capr_id, capr_nombre) FROM stdin;
    public          postgres    false    201   !2       ?          0    88000    cliente 
   TABLE DATA           t   COPY public.cliente (clien_id, clien_cedula, clien_nombres, clien_apellidos, clien_correo, clien_telef) FROM stdin;
    public          postgres    false    207   V2       ?          0    88018    detalle_pedido 
   TABLE DATA           R   COPY public.detalle_pedido (depe_id, orde_id, prod_id, depe_cantidad) FROM stdin;
    public          postgres    false    209   ?2       ?          0    87984    orden 
   TABLE DATA           b   COPY public.orden (orde_id, clien_id, orde_fecha, orde_direccion_env, orde_costo_env) FROM stdin;
    public          postgres    false    205   ?3       ?          0    87951    producto 
   TABLE DATA           Z   COPY public.producto (prod_id, prod_nombre, prod_precio, prod_stock, capr_id) FROM stdin;
    public          postgres    false    203   ?4       ?           0    0    categoria_producto_capr_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.categoria_producto_capr_id_seq', 2, true);
          public          postgres    false    200            ?           0    0    cliente_clien_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cliente_clien_id_seq', 3, true);
          public          postgres    false    206            ?           0    0    detalle_pedido_depe_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.detalle_pedido_depe_id_seq', 59, true);
          public          postgres    false    208            ?           0    0    orden_orde_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.orden_orde_id_seq', 43, true);
          public          postgres    false    204            ?           0    0    producto_prod_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.producto_prod_id_seq', 3, true);
          public          postgres    false    202            D           2606    87948 *   categoria_producto categoria_producto_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.categoria_producto
    ADD CONSTRAINT categoria_producto_pkey PRIMARY KEY (capr_id);
 T   ALTER TABLE ONLY public.categoria_producto DROP CONSTRAINT categoria_producto_pkey;
       public            postgres    false    201            J           2606    88008    cliente cliente_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (clien_id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    207            N           2606    88023 "   detalle_pedido detalle_pedido_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.detalle_pedido
    ADD CONSTRAINT detalle_pedido_pkey PRIMARY KEY (depe_id);
 L   ALTER TABLE ONLY public.detalle_pedido DROP CONSTRAINT detalle_pedido_pkey;
       public            postgres    false    209            H           2606    87992    orden orden_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT orden_pkey PRIMARY KEY (orde_id);
 :   ALTER TABLE ONLY public.orden DROP CONSTRAINT orden_pkey;
       public            postgres    false    205            F           2606    87959    producto producto_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (prod_id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public            postgres    false    203            L           2606    88015    cliente uq_clien_cedula 
   CONSTRAINT     q   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT uq_clien_cedula UNIQUE (clien_cedula) INCLUDE (clien_cedula);
 A   ALTER TABLE ONLY public.cliente DROP CONSTRAINT uq_clien_cedula;
       public            postgres    false    207    207            O           2606    87993    producto fk_capr_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT fk_capr_id FOREIGN KEY (capr_id) REFERENCES public.categoria_producto(capr_id) NOT VALID;
 =   ALTER TABLE ONLY public.producto DROP CONSTRAINT fk_capr_id;
       public          postgres    false    203    2884    201            P           2606    88009    orden fk_clien_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.orden
    ADD CONSTRAINT fk_clien_id FOREIGN KEY (clien_id) REFERENCES public.cliente(clien_id) NOT VALID;
 ;   ALTER TABLE ONLY public.orden DROP CONSTRAINT fk_clien_id;
       public          postgres    false    2890    207    205            Q           2606    88024    detalle_pedido fk_orde_id    FK CONSTRAINT     }   ALTER TABLE ONLY public.detalle_pedido
    ADD CONSTRAINT fk_orde_id FOREIGN KEY (orde_id) REFERENCES public.orden(orde_id);
 C   ALTER TABLE ONLY public.detalle_pedido DROP CONSTRAINT fk_orde_id;
       public          postgres    false    2888    209    205            R           2606    88029    detalle_pedido fk_prod_id    FK CONSTRAINT     ?   ALTER TABLE ONLY public.detalle_pedido
    ADD CONSTRAINT fk_prod_id FOREIGN KEY (prod_id) REFERENCES public.producto(prod_id);
 C   ALTER TABLE ONLY public.detalle_pedido DROP CONSTRAINT fk_prod_id;
       public          postgres    false    209    203    2886            ?   %   x?3???OO,?2?t??+.)*MN?<?9?+F??? ?A	$      ?   {   x?E?1? ???>??4?ei??]q?HD4Yr?Щғ??}x /~`??\>Z?[:+??˨e׶???&?(	???Ё???d`?6?HD??t????t??Ւu<????;?Q??s?2?x5?$?      ?   ?   x?%?ё?0?E17? ;???_?!?0?5NV??ll?????E??ĩuة???ִ????.??g6?RϡU@]?ʽ???+?k?????!??cE????	f????J/?????:?|??>)?E??	?<w??ӘdOQ?? ?????c??\Ͻ????ՁZ? ?u?E屨?3?)??ʸc?"j?24?g?Dĵ\"Y???L???՟\m?ɒ??)? ?s?յ,???O??ߟ??;lI      ?   ?   x?}??? Dg?_??i??????????li%???8LLP`S?	?{??G???KQ\???~??%un?d.~?.̫?????c?????????d9-\l?9Ǜ?9d9?r???_N??*ȟq@&Lִ;E=?A??23??????Ir&ə$o??y^??4
???,??6????
?      ?   a   x???? ???L???Az??
??q???2Ck??%??q1u?(??X??<OH????ֹ??S?!?G?|F@??U???VץT>1??n??~.?}     