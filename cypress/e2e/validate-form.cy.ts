describe('validate form', () => {
  it('passes', () => {
    cy.visit('http://localhost:5173/ContactForms')
    cy.get("#form-name").type("Sondre Malerud")
    cy.get("#btn-submit").should('be.disabled')

    cy.get("#email").type('test@test.com')
    cy.get("#btn-submit").should('be.disabled')

    cy.get("#message").type('bla bla bla')
    cy.get("#btn-submit").should('not.be.disabled')

    cy.get("#email").type('test')
    cy.get("#btn-submit").should('be.disabled')
  })
})