describe('submit form', () => {
    it('passes', () => {
      cy.visit('http://localhost:5173/ContactForms')
      cy.get("#form-name").type("Sondre Malerud")
  
      cy.get("#email").type('test@test.com')
  
      cy.get("#message").type('Hei fra Cypress! :D')
  
      cy.get("#btn-submit").trigger('click')

      
    })
  })