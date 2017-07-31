module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        concat: {
            options: {
                separator: ';',
            },
            dist: {
                src: ['src/main/webapp/resources/app/login-module.js','src/main/webapp/resources/app/services/*.js','src/main/webapp/resources/app/login-module/*.js'],
                dest: 'src/main/webapp/resources/js/flikon.js',
            },
        },
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'src/main/webapp/resources/js/flikon.js',
                dest: 'src/main/webapp/resources/js/flikon.min.js'
            }
        },
        mavenPrepare: {
            options: {
                resources: ['src/main/webapp/resources/app/**']
            },
            prepare: {}
        },
    });

    // Load the plugin that provides the "uglify" task.
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-maven');

    // Default task(s).
    grunt.registerTask('default', ['concat','uglify']);

};