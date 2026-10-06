# Sistema de Pedidos — Projeto OO

Projeto didático em Java puro para demonstrar:

- responsabilidades, coesão e acoplamento;
- SOLID;
- Strategy;
- Factory Method;
- Adapter;
- injeção de dependência manual.

## Execução

Abra a pasta no VS Code com o Extension Pack for Java instalado e execute `src/Main.java`.

## Padrões

- **Strategy**: `PagamentoStrategy`, `PagamentoPix`, `PagamentoCartao` e `GatewayLegadoAdapter`.
- **Factory Method**: `NotificadorFactory` e suas subclasses concretas.
- **Adapter**: `GatewayLegadoAdapter` adapta `GatewayPagamentoLegado` ao contrato `PagamentoStrategy`.
