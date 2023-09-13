(function() {
  "use strict";

  /**
   * Easy selector helper function
   */
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  /**
   * Easy event listener function
   */
  const on = (type, el, listener, all = false) => {
    if (all) {
      select(el, all).forEach(e => e.addEventListener(type, listener))
    } else {
      select(el, all).addEventListener(type, listener)
    }
  }

  /**
   * Easy on scroll event listener 
   */
  const onscroll = (el, listener) => {
    el.addEventListener('scroll', listener)
  }

  /**
   * Sidebar toggle
   */
  if (select('.toggle-sidebar-btn')) {
    on('click', '.toggle-sidebar-btn', function(e) {
      select('body').classList.toggle('toggle-sidebar')
    })
  }

  /**
   * Search bar toggle
   */
  if (select('.search-bar-toggle')) {
    on('click', '.search-bar-toggle', function(e) {
      select('.search-bar').classList.toggle('search-bar-show')
    })
  }

  /**
   * Navbar links active state on scroll
   */
  let navbarlinks = select('#navbar .scrollto', true)
  const navbarlinksActive = () => {
    let position = window.scrollY + 200
    navbarlinks.forEach(navbarlink => {
      if (!navbarlink.hash) return
      let section = select(navbarlink.hash)
      if (!section) return
      if (position >= section.offsetTop && position <= (section.offsetTop + section.offsetHeight)) {
        navbarlink.classList.add('active')
      } else {
        navbarlink.classList.remove('active')
      }
    })
  }
  window.addEventListener('load', navbarlinksActive)
  onscroll(document, navbarlinksActive)

  /**
   * Toggle .header-scrolled class to #header when page is scrolled
   */
  let selectHeader = select('#header')
  if (selectHeader) {
    const headerScrolled = () => {
      if (window.scrollY > 100) {
        selectHeader.classList.add('header-scrolled')
      } else {
        selectHeader.classList.remove('header-scrolled')
      }
    }
    window.addEventListener('load', headerScrolled)
    onscroll(document, headerScrolled)
  }

  /**
   * Back to top button
   */
  let backtotop = select('.back-to-top')
  if (backtotop) {
    const toggleBacktotop = () => {
      if (window.scrollY > 100) {
        backtotop.classList.add('active')
      } else {
        backtotop.classList.remove('active')
      }
    }
    window.addEventListener('load', toggleBacktotop)
    onscroll(document, toggleBacktotop)
  }

  /**
   * Initiate tooltips
   */
  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
  var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
    return new bootstrap.Tooltip(tooltipTriggerEl)
  })

  /**
   * Initiate quill editors
   */
  if (select('.quill-editor-default')) {
    new Quill('.quill-editor-default', {
      theme: 'snow'
    });
  }

  if (select('.quill-editor-bubble')) {
    new Quill('.quill-editor-bubble', {
      theme: 'bubble'
    });
  }

  if (select('.quill-editor-full')) {
    new Quill(".quill-editor-full", {
      modules: {
        toolbar: [
          [{
            font: []
          }, {
            size: []
          }],
          ["bold", "italic", "underline", "strike"],
          [{
              color: []
            },
            {
              background: []
            }
          ],
          [{
              script: "super"
            },
            {
              script: "sub"
            }
          ],
          [{
              list: "ordered"
            },
            {
              list: "bullet"
            },
            {
              indent: "-1"
            },
            {
              indent: "+1"
            }
          ],
          ["direction", {
            align: []
          }],
          ["link", "image", "video"],
          ["clean"]
        ]
      },
      theme: "snow"
    });
  }

  /**
   * Initiate TinyMCE Editor
   */
  const useDarkMode = window.matchMedia('(prefers-color-scheme: dark)').matches;
  const isSmallScreen = window.matchMedia('(max-width: 1023.5px)').matches;

  tinymce.init({
    selector: 'textarea.tinymce-editor',
    plugins: 'preview importcss searchreplace autolink autosave save directionality code visualblocks visualchars fullscreen image link media template codesample table charmap pagebreak nonbreaking anchor insertdatetime advlist lists wordcount help charmap quickbars emoticons',
    editimage_cors_hosts: ['picsum.photos'],
    menubar: 'file edit view insert format tools table help',
    toolbar: 'undo redo | bold italic underline strikethrough | fontfamily fontsize blocks | alignleft aligncenter alignright alignjustify | outdent indent |  numlist bullist | forecolor backcolor removeformat | pagebreak | charmap emoticons | fullscreen  preview save print | insertfile image media template link anchor codesample | ltr rtl',
    toolbar_sticky: true,
    toolbar_sticky_offset: isSmallScreen ? 102 : 108,
    autosave_ask_before_unload: true,
    autosave_interval: '30s',
    autosave_prefix: '{path}{query}-{id}-',
    autosave_restore_when_empty: false,
    autosave_retention: '2m',
    image_advtab: true,
    link_list: [{
        title: 'My page 1',
        value: 'https://www.tiny.cloud'
      },
      {
        title: 'My page 2',
        value: 'http://www.moxiecode.com'
      }
    ],
    image_list: [{
        title: 'My page 1',
        value: 'https://www.tiny.cloud'
      },
      {
        title: 'My page 2',
        value: 'http://www.moxiecode.com'
      }
    ],
    image_class_list: [{
        title: 'None',
        value: ''
      },
      {
        title: 'Some class',
        value: 'class-name'
      }
    ],
    importcss_append: true,
    file_picker_callback: (callback, value, meta) => {
      /* Provide file and text for the link dialog */
      if (meta.filetype === 'file') {
        callback('https://www.google.com/logos/google.jpg', {
          text: 'My text'
        });
      }

      /* Provide image and alt text for the image dialog */
      if (meta.filetype === 'image') {
        callback('https://www.google.com/logos/google.jpg', {
          alt: 'My alt text'
        });
      }

      /* Provide alternative source and posted for the media dialog */
      if (meta.filetype === 'media') {
        callback('movie.mp4', {
          source2: 'alt.ogg',
          poster: 'https://www.google.com/logos/google.jpg'
        });
      }
    },
    templates: [{
        title: 'New Table',
        description: 'creates a new table',
        content: '<div class="mceTmpl"><table width="98%%"  border="0" cellspacing="0" cellpadding="0"><tr><th scope="col"> </th><th scope="col"> </th></tr><tr><td> </td><td> </td></tr></table></div>'
      },
      {
        title: 'Starting my story',
        description: 'A cure for writers block',
        content: 'Once upon a time...'
      },
      {
        title: 'New list with dates',
        description: 'New List with dates',
        content: '<div class="mceTmpl"><span class="cdate">cdate</span><br><span class="mdate">mdate</span><h2>My List</h2><ul><li></li><li></li></ul></div>'
      }
    ],
    template_cdate_format: '[Date Created (CDATE): %m/%d/%Y : %H:%M:%S]',
    template_mdate_format: '[Date Modified (MDATE): %m/%d/%Y : %H:%M:%S]',
    height: 600,
    image_caption: true,
    quickbars_selection_toolbar: 'bold italic | quicklink h2 h3 blockquote quickimage quicktable',
    noneditable_class: 'mceNonEditable',
    toolbar_mode: 'sliding',
    contextmenu: 'link image table',
    skin: useDarkMode ? 'oxide-dark' : 'oxide',
    content_css: useDarkMode ? 'dark' : 'default',
    content_style: 'body { font-family:Helvetica,Arial,sans-serif; font-size:16px }'
  });

  /**
   * Initiate Bootstrap validation check
   */
  var needsValidation = document.querySelectorAll('.needs-validation')

  Array.prototype.slice.call(needsValidation)
    .forEach(function(form) {
      form.addEventListener('submit', function(event) {
        if (!form.checkValidity()) {
          event.preventDefault()
          event.stopPropagation()
        }

        form.classList.add('was-validated')
      }, false)
    })

  /**
   * Initiate Datatables
   */
  const datatables = select('.datatable', true)
  datatables.forEach(datatable => {
    new simpleDatatables.DataTable(datatable);
  })

  /**
   * Autoresize echart charts
   */
  const mainContainer = select('#main');
  if (mainContainer) {
    setTimeout(() => {
      new ResizeObserver(function() {
        select('.echart', true).forEach(getEchart => {
          echarts.getInstanceByDom(getEchart).resize();
        })
      }).observe(mainContainer);
    }, 200);
  }

})();

//----------------------------------------------------------ProcedureDetails JS-------------------------------------
//auto increment patientprocedurenumber--------
 var nameInput = document.getElementById("patientprocedurenumber");
 if(nameInput !== null){
	 nameInput.addEventListener("input", incrementInput);
	function incrementInput() {
		console.log("incrementInput called");
	  	var input = document.getElementById("patientprocedurenumber");
	  	input.value++;
}
}
//end of autoincrement patientprocedurenumber-------
//patientprocedure future date validation------------------
 // Get the current date in the format yyyy-mm-dd
  const currentDate = new Date().toISOString().split('T')[0];
  // Set the max attribute of the input element to the current date
  var procedureDate = document.querySelector('#patientproceduredate');
  if(procedureDate !== null){
	  console.log("sdate");
	procedureDate.setAttribute('max', currentDate);  
  }
//end of patientprocedure future validation------------------
//---------------validate patientproceduredetail (with numbers)---------------
var procedureDetail = document.getElementById("patientproceduredetail");
if (procedureDetail !== null) {
  // Add an event listener to the name input field
  procedureDetail.addEventListener("input", validateProcedureDetail);

  function validateProcedureDetail() {
    var name = procedureDetail.value;
    var nameRegex = /^(?=.*[a-zA-Z])[a-zA-Z0-9]+(([',. -][a-zA-Z ])?[a-zA-Z0-9]*)*$/;
    var procedureDetailError = document.getElementById("procedureDetailError");
    
    if (name.trim() === '') {
      procedureDetailError.style.display = "none"; // Hide error when field is empty
      return true; // No error when field is empty
    }
    
    if (!nameRegex.test(name)) {
      procedureDetailError.style.display = "block";
      return false;
    } else {
      procedureDetailError.style.display = "none";
      return true;
    }
  }
}
//end of validate patientproceduredetail--------
//---------------validate patientprocedurelabname (with numbers)---------------
var labName = document.getElementById("patientprocedurelabname");
if (labName !== null) {
  // Add an event listener to the name input field
  procedureDetail.addEventListener("input", validateLabName);

  function validateLabName() {
    var name = labName.value;
    var nameRegex = /^(?=.*[a-zA-Z])[a-zA-Z0-9]+(([',. -][a-zA-Z ])?[a-zA-Z0-9]*)*$/;
    var labNameError = document.getElementById("labNameError");
    
    if (name.trim() === '') {
      labNameError.style.display = "none"; // Hide error when field is empty
      return true; // No error when field is empty
    }
    
    if (!nameRegex.test(name)) {
      labNameError.style.display = "block";
      return false;
    } else {
      labNameError.style.display = "none";
      return true;
    }
  }
}
//end of validate patientprocedurelabname--------
//submit procedureDetails form validation-------------------
const form = document.getElementById('procedureDetails'); // replace 'myForm' with the ID of your form element 
if(form !== null){
	form.addEventListener('submit', function(event) {
  const ProcedureDetailValid = validateProcedureDetail();
  if (!ProcedureDetailValid) {
    event.preventDefault();
    return;
  }
  const labNameValid = validateLabName();
  if (!labNameValid) {
    event.preventDefault();
    return;
  }
  });
}
//end of submit procedureDetails form validation-------------------

    
const estimateInput = document.getElementById("estimate");
const cashInput = document.getElementById("cash"); // Added
const onlineInput = document.getElementById("online"); // Added
const paymentInput = document.getElementById("payment");
const balanceInput = document.getElementById("balance");

// Function to calculate and update the balance
function updateBalance() {
    const estimate = parseFloat(estimateInput.value) || 0;
    const cashPayment = parseFloat(cashInput.value) || 0; // Added
    const onlinePayment = parseFloat(onlineInput.value) || 0; // Added
    const totalPayment = cashPayment + onlinePayment; // Calculate total payment

    const balance = estimate - totalPayment;

    // Update the payment input field
    paymentInput.value = totalPayment;

    // Update the balance input field
    balanceInput.value = balance;
}

// Attach an event listener to estimate, cash, and online payment inputs to update the balance
estimateInput.addEventListener("input", updateBalance);
cashInput.addEventListener("input", updateBalance);
onlineInput.addEventListener("input", updateBalance);

// Initial calculation when the page loads
updateBalance();
