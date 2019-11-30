# Stripe API demo

A quick drive through the [Stripe Java API](https://github.com/stripe/stripe-java) using Clojure

## Installation

1. Create a Stripe account an [retrieve a secret key](https://stripe.com/docs/api/authentication).
1. Place the secret key in the project root `<root>/profiles.clj` file. This project uses [environ](https://github.com/weavejester/environ) to manage local environment variables. The `profiles-example.clj` will contain the correct format for the dev environment.
1. Install [Leiningen](https://leiningen.org/) and run from the root. The easiest way to do this is by using [sdkman](https://sdkman.io/install).

Next, run from the command line

```clojure
lein run --amount 100 --currency USD --source tok_visa
```

* amount: Any subunit amount that agrees with a currency's [exponent](https://en.wikipedia.org/wiki/ISO_4217)
* currency: An ISO-3166 Country code for the amount
* source: Stripe [token](https://stripe.com/docs/testing#cards) in test or from Stripe.js

If the secret key is valid and placed inside the `profiles.clj` file, then the CLI output will represent the Stripe charge response

Example response truncated for your sanity and mine:

```json
{
  "amount": 100,
  "amount_refunded": 0,
  "balance_transaction": "txn_...",
  "captured": true
}
```
