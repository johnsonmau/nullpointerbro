// Newsletter form handling
document.getElementById('newsletterForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const email = this.querySelector('input[type="email"]').value;

    // Replace this with your actual newsletter signup logic
    // Could be Mailchimp, ConvertKit, or a simple backend endpoint
    console.log('Newsletter signup:', email);

    alert('Thanks for signing up! We\'ll notify you when we launch. 🚀');
    this.reset();
});

// Add smooth scroll behavior
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth'
            });
        }
    });
});

// Add entrance animations
window.addEventListener('load', function() {
    const cards = document.querySelectorAll('.card, .affiliate-section, .newsletter-section');
    cards.forEach((card, index) => {
        setTimeout(() => {
            card.style.opacity = '0';
            card.style.transform = 'translateY(20px)';
            card.style.transition = 'all 0.6s ease';

            setTimeout(() => {
                card.style.opacity = '1';
                card.style.transform = 'translateY(0)';
            }, 50);
        }, index * 100);
    });
});