INSERT INTO teste (
    valor,
    idPagante,
    idReceptante,
    nomeReceptante,
    idadeReceptante,
    dataTransacao,
    formaPagamento,
    tipoConta,
    cpfReceptante,
    bancoReceptante,
    cnpjReceptante
) VALUES
(
    150.75,
    'pagante123',
    'receptante456',
    'Maria Silva',
    30,
    '2025-11-28',
    'PIX',
    'corrente',
    '123.456.789-00',
    'Banco do Brasil',
    '12.345.678/0001-99'
),
(
    200.00,
    'pagante789',
    'receptante987',
    'João Santos',
    45,
    '2025-11-27',
    'TED',
    'poupanca',
    '987.654.321-00',
    'Bradesco',
    NULL
);
